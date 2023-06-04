package com.amr.tc.bs.car.carifr.api.req;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Builder
@Setter
@Getter
public class CreateCarReq {

@NotNull(message = "Car id is required")
    private UUID carId;
    @NotNull(message = "Vim id is required")
    private UUID vimId;
    @NotNull(message = "Type model id is required")
    private UUID typeModelId;
    @NotNull(message = "Engine id is required")
    private UUID engineId;
    @NotNull(message = "The car body is required")
    private UUID bodyId;
    @NotNull(message = "Brake is required")
    private UUID brakeId;
    @NotNull(message = "Suspension id is required")
    private UUID suspensionId;
    @NotNull(message = "Gearbox is required")
    private UUID gearBoxId;

}
