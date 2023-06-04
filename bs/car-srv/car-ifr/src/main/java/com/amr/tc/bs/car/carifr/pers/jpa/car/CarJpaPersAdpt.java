package com.amr.tc.bs.car.carifr.pers.jpa.car;

import com.amr.tc.bs.car.cardom.main.mdl.CarAgg;
import com.amr.tc.bs.car.cardom.main.port.out.ICarPersSvc;
import com.amr.tc.bs.car.carifr.pers.jpa.exc.CarNotFoundException;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;
import com.amr.tc.shared.shdbs.infra.annot.InfraSvc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Slf4j
@InfraSvc
public class CarJpaPersAdpt implements ICarPersSvc {

    private final CarJpaRepo carJpaRepository;
    private final CarJpaMpr carJpaMapper;

    @Autowired
    public CarJpaPersAdpt(CarJpaRepo carJpaRepository) {

        this.carJpaRepository = carJpaRepository;
        carJpaMapper = new CarJpaMpr();

    }

    @Override
    public void save(CarAgg car) {

        Optional<CarJpaEnt> isExist = carJpaRepository.findById(car.getId().getValue());

        if (isExist.isPresent()) {
            throw new CarNotFoundException("The cart already exists, it is not possible to save");
        }
        CarJpaEnt carEntity = carJpaMapper.car_to_carEntity(car);
        carJpaRepository.save(carEntity);

    }

    @Override
    public void delete_by_id(CarId carId) throws CarNotFoundException {

        carJpaRepository.findById(carId.getValue())
                        .orElseThrow(() -> new CarNotFoundException(
                                "The cart does not exist, it is not possible to delete it."));
        carJpaRepository.deleteById(carId.getValue());

    }

    @Override
    public void update_by_id(CarAgg car) {

        carJpaRepository.findById(car.getId().getValue())
                        .orElseThrow(() -> new CarNotFoundException(
                                "The car does not exist, it is not possible to update it"));

        CarJpaEnt carEntity = carJpaMapper.prepare_car_entity_for_update(car);
        carJpaRepository.save(carEntity);

    }

    @Override
    public List<CarAgg> get_all_customer() {

        return carJpaRepository.findAll().stream().map(carJpaMapper::carEntity_to_car).toList();
    }

    @Override
    public Optional<CarAgg> get_customer_by_id(CarId carId) {

        Optional<CarJpaEnt> find = Optional.of(carJpaRepository.findById(carId.getValue())
                                                               .orElseThrow(() -> new CarNotFoundException(
                                                                       "The car does not exist, it is not possible to obtain it")));

        return Optional.of(find.map(carJpaMapper::carEntity_to_car)
                               .orElseThrow(() -> new CarNotFoundException(
                                       "Error in obtaining the vehicle, the mapping was wrong")));
    }

}
