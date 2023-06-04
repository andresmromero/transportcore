package com.amr.tc.shared.shdbs.infra.exc;

import lombok.Builder;

@Builder
public record ErrorDto(String code, String message) {
}
