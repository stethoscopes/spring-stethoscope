package org.dev.stethoscope.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.dev.stethoscope.constants.swagger.SwaggerHttpCodeMessage;

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = SwaggerHttpCodeMessage.OK),
        @ApiResponse(responseCode = "400", description = SwaggerHttpCodeMessage.BAD_REQUEST, content = @Content),
        @ApiResponse(responseCode = "401", description = SwaggerHttpCodeMessage.UNAUTHENTICATED, content = @Content),
        @ApiResponse(responseCode = "403", description = SwaggerHttpCodeMessage.FORBIDDEN, content = @Content),
        @ApiResponse(responseCode = "404", description = SwaggerHttpCodeMessage.NOT_FOUND, content = @Content),
        @ApiResponse(responseCode = "500", description = SwaggerHttpCodeMessage.INTERNAL_SERVER_ERROR, content = @Content),
})
public class BaseController {
}
