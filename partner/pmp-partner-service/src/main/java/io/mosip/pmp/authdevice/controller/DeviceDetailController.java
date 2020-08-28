package io.mosip.pmp.authdevice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.kernel.core.http.ResponseFilter;
import io.mosip.pmp.authdevice.dto.DeviceDetailDto;
import io.mosip.pmp.authdevice.dto.IdDto;
import io.mosip.pmp.authdevice.service.DeviceDetaillService;
import io.mosip.pmp.authdevice.util.AuditUtil;
import io.mosip.pmp.authdevice.util.AuthDeviceConstant;
import io.mosip.pmp.partner.core.RequestWrapper;
import io.mosip.pmp.partner.core.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/devicedetail")
@Api(tags = { "DeviceDetail" })
public class DeviceDetailController {
	@Autowired
	AuditUtil auditUtil;
	@Autowired
	DeviceDetaillService deviceDetaillService;
	/**
	 * Post API to insert a new row of MOSIPDeviceService data
	 * 
	 * @param MOSIPDeviceServiceRequestDto input parameter deviceRequestDto
	 * 
	 * @return ResponseEntity MOSIPDeviceService which is inserted successfully
	 *         {@link ResponseEntity}
	 */
	@PreAuthorize("hasRole('ZONAL_ADMIN')")
	@ResponseFilter
	@PostMapping
	@ApiOperation(value = "Service to save DeviceDetail", notes = "Saves DeviceDetail and return DeviceDetail id")
	@ApiResponses({ @ApiResponse(code = 201, message = "When DeviceDetail successfully created"),
			@ApiResponse(code = 400, message = "When Request body passed  is null or invalid"),
			@ApiResponse(code = 500, message = "While creating DeviceDetail any error occured") })
	public ResponseWrapper<IdDto> createDeviceDetail(
			@Valid @RequestBody RequestWrapper<DeviceDetailDto> deviceDetailRequestDto) {
		auditUtil.auditRequest(
				AuthDeviceConstant.CREATE_API_IS_CALLED + DeviceDetailDto.class.getCanonicalName(),
				AuthDeviceConstant.AUDIT_SYSTEM,
				AuthDeviceConstant.CREATE_API_IS_CALLED + DeviceDetailDto.class.getCanonicalName(),
				"AUT-001");
		ResponseWrapper<IdDto> responseWrapper = new ResponseWrapper<>();
		responseWrapper
				.setResponse(deviceDetaillService.createDeviceDetails(deviceDetailRequestDto.getRequest()));
		auditUtil.auditRequest(
				String.format(AuthDeviceConstant.SUCCESSFUL_CREATE , DeviceDetailDto.class.getCanonicalName()),
				AuthDeviceConstant.AUDIT_SYSTEM,
				String.format(AuthDeviceConstant.SUCCESSFUL_CREATE , DeviceDetailDto.class.getCanonicalName()),
				"AUT-005");
		return responseWrapper;

	}

	/**
	 * Put API to update a row of MOSIPDeviceService data
	 * 
	 * @param MOSIPDeviceServiceRequestDto input parameter deviceRequestDto
	 * 
	 * @return ResponseEntity MOSIPDeviceService which is updated successfully
	 *         {@link ResponseEntity}
	 */
	@PreAuthorize("hasRole('ZONAL_ADMIN')")
	@ResponseFilter
	@PutMapping
	@ApiOperation(value = "Service to update DeviceDetail", notes = "Updates DeviceDetail and returns success message")
	@ApiResponses({ @ApiResponse(code = 201, message = "When DeviceDetail successfully updated"),
			@ApiResponse(code = 400, message = "When Request body passed  is null or invalid"),
			@ApiResponse(code = 500, message = "While updating DeviceDetail any error occured") })
	public ResponseWrapper<IdDto> updateDeviceDetail(
			@Valid @RequestBody RequestWrapper<DeviceDetailDto> deviceDetailRequestDto) {
		auditUtil.auditRequest(
				AuthDeviceConstant.UPDATE_API_IS_CALLED + DeviceDetailDto.class.getCanonicalName(),
				AuthDeviceConstant.AUDIT_SYSTEM,
				AuthDeviceConstant.UPDATE_API_IS_CALLED + DeviceDetailDto.class.getCanonicalName(),
				"AUT-006");
		ResponseWrapper<IdDto> responseWrapper = new ResponseWrapper<>();
		responseWrapper
				.setResponse(deviceDetaillService.updateDeviceDetails(deviceDetailRequestDto.getRequest()));
		auditUtil.auditRequest(
				String.format(AuthDeviceConstant.SUCCESSFUL_UPDATE , DeviceDetailDto.class.getCanonicalName()),
				AuthDeviceConstant.AUDIT_SYSTEM,
				String.format(AuthDeviceConstant.SUCCESSFUL_UPDATE , DeviceDetailDto.class.getCanonicalName()),
				"AUT-007");
		return responseWrapper;

	}
}