package com.bankapp.api;

import com.bankapp.dto.request.AccountRequest;
import com.bankapp.dto.response.AccountResponse;
import com.bankapp.exception.ErrorExtension;
import com.bankapp.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller for operations with account
 *
 * @author Iurii Ivanov
 */

@RequestMapping("/account")
@RestController
@RequiredArgsConstructor
@Tag(name = "Account controller", description = "API for work with accounts")
public class AccountController {

    private final AccountService accountService;


    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all client's accounts", description = "Get list of all client's accounts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returned all client's accounts", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema =
                            @Schema(implementation = AccountRequest.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Accounts for user with ID not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public List<AccountResponse> getAllUsersAccounts(@UUID @PathVariable String clientId) {
        return accountService.getAllClientAccounts(clientId);
    }

    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all client's accounts", description = "Get list of all client's accounts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Returned all client's accounts", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema =
                            @Schema(implementation = AccountRequest.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Accounts for user with ID not found", content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorExtension.class))
            })
    })
    public List<AccountResponse> getAllUsersAccounts(@UUID @PathVariable String clientId) {
        return accountService.getAllClientAccounts(clientId);
    }
}
