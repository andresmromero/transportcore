package com.amr.tc.bs.car.cardom.main.mdl;


import com.amr.tc.bs.car.cardom.main.mdl.vo.*;
import com.amr.tc.shared.shdbs.dom.attr_id.CarId;
import com.amr.tc.shared.shdbs.dom.mdl.AggregateRoot;
import lombok.Getter;

@Getter
public class CarAgg extends AggregateRoot<CarId> {

    private final CarVimId vimId;
    private final CarTypeModelId typeModelId;
    private final CarEngineId engineId;
    private final CarBodyId bodyId;
    private final CarBrakeId brakeId;
    private final CarSuspensionId suspensionId;
    private final CarGearBoxId gearBoxId;

    private CarAgg(Builder builder) {

        super.setId(builder.carId);
        vimId = builder.vimId;
        typeModelId = builder.typeModelId;
        engineId = builder.engineId;
        bodyId = builder.bodyId;
        brakeId = builder.brakeId;
        suspensionId = builder.suspensionId;
        gearBoxId = builder.gearBoxId;
    }


    public static final class Builder {

        private CarVimId vimId;
        private CarTypeModelId typeModelId;
        private CarEngineId engineId;
        private CarBodyId bodyId;
        private CarBrakeId brakeId;
        private CarSuspensionId suspensionId;
        private CarGearBoxId gearBoxId;
        private CarId carId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder vimId(CarVimId val) {

            vimId = val;
            return this;
        }

        public Builder typeModelId(CarTypeModelId val) {

            typeModelId = val;
            return this;
        }

        public Builder engineId(CarEngineId val) {

            engineId = val;
            return this;
        }

        public Builder bodyId(CarBodyId val) {

            bodyId = val;
            return this;
        }

        public Builder brakeId(CarBrakeId val) {

            brakeId = val;
            return this;
        }

        public Builder suspensionId(CarSuspensionId val) {

            suspensionId = val;
            return this;
        }

        public Builder gearBoxId(CarGearBoxId val) {

            gearBoxId = val;
            return this;
        }

        public Builder carId(CarId val) {

            carId = val;
            return this;
        }

        public CarAgg build() {

            return new CarAgg(this);
        }

    }

}

