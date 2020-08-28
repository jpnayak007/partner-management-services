package io.mosip.pmp.authdevice.service;

import org.springframework.stereotype.Service;

import io.mosip.pmp.authdevice.dto.DeviceDetailDto;
import io.mosip.pmp.authdevice.dto.IdDto;
@Service
public interface DeviceDetaillService {
	/**
	 * Function to save Device  Details to the Database
	 * 
	 * @param deviceDetails input from user deviceDetails DTO
	 * 
	 * @return IdResponseDto Device Details ID which is successfully inserted
	 * @throws AuthDeviceServiceException if any error occurred while saving device
	 *                                    Specification
	 */
	public IdDto createDeviceDetails(DeviceDetailDto deviceDetails);

	/**
	 * Function to update Device Details
	 * 
	 * @param deviceDetails input from user deviceDetails DTO
	 * 
	 * @return IdResponseDto Device Details ID which is successfully updated
	 * @throws AuthDeviceServiceException if any error occurred while updating
	 *                                    device Specification
	 */

	public IdDto updateDeviceDetails(DeviceDetailDto deviceDetails);
}