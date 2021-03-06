package io.mosip.pmp.authdevice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.mosip.kernel.core.http.ResponseFilter;
import io.mosip.pmp.authdevice.dto.DeRegisterDevicePostDto;
import io.mosip.pmp.authdevice.dto.RegisteredDevicePostDto;
import io.mosip.pmp.authdevice.service.RegisteredDeviceService;
import io.mosip.pmp.regdevice.service.RegRegisteredDeviceService;
import io.mosip.pmp.partner.core.RequestWrapper;
import io.mosip.pmp.partner.core.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/registereddevices")
@Api(tags = { "Registered Device" })
@Validated
public class RegisteredDeviceController {

	@Autowired
	RegisteredDeviceService registeredDeviceService;
	
	@Autowired
	RegRegisteredDeviceService regRegisteredDeviceService;

	/**
	 * Api to Register Device.
	 * 
	 * Digitally signed device
	 * 
	 * @param registeredDevicePostDto
	 * @return ResponseWrapper<String>
	 * @throws Exception
	 */
	@ResponseFilter
	@PreAuthorize("hasAnyRole('PARTNER')")
	@PostMapping
	public ResponseWrapper<String> signedRegisteredDevice(
			@Valid @RequestBody RequestWrapper<RegisteredDevicePostDto> registeredDevicePostDto) throws Exception {
		ResponseWrapper<String> response = new ResponseWrapper<>();
		if(registeredDevicePostDto.getRequest().getIsItForRegistrationDevice()) {
			response.setResponse(regRegisteredDeviceService.signedRegisteredDevice(registeredDevicePostDto.getRequest()));
		}else {
			response.setResponse(registeredDeviceService.signedRegisteredDevice(registeredDevicePostDto.getRequest()));			
		}

		return response;
	}

	/**
	 * Api to de-register Device.
	 * 
	 * @param request
	 *            the request DTO.
	 * @return the {@link DeviceRegisterResponseDto}.
	 */
	@PreAuthorize("hasAnyRole('PARTNER')")
	@ApiOperation(value = "DeRegister Device")
	@PostMapping("/deregister")
	@ResponseFilter
	public ResponseWrapper<String> deRegisterDevice(@Valid @RequestBody RequestWrapper<DeRegisterDevicePostDto>
							deRegisterDevicePostDto) {
		ResponseWrapper<String> response = new ResponseWrapper<>();
		if(deRegisterDevicePostDto.getRequest().getIsItForRegistrationDevice()) {
			response.setResponse(regRegisteredDeviceService.deRegisterDevice(deRegisterDevicePostDto.getRequest()));			
		}else {
			response.setResponse(registeredDeviceService.deRegisterDevice(deRegisterDevicePostDto.getRequest()));
		}
		return response;
	}

	

}

