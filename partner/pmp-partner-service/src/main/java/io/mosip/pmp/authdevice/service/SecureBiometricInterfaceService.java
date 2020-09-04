package io.mosip.pmp.authdevice.service;

import io.mosip.pmp.authdevice.dto.IdDto;
import io.mosip.pmp.authdevice.dto.SecureBiometricInterfaceCreateDto;
import io.mosip.pmp.authdevice.dto.SecureBiometricInterfaceStatusUpdateDto;
import io.mosip.pmp.authdevice.dto.SecureBiometricInterfaceUpdateDto;


public interface SecureBiometricInterfaceService {
	
	public IdDto createSecureBiometricInterface(SecureBiometricInterfaceCreateDto secureBiometricInterfaceDto);
	
	public IdDto updateSecureBiometricInterface(SecureBiometricInterfaceUpdateDto secureBiometricInterfaceDto);
	
	public String updateSecureBiometricInterfaceStatus(SecureBiometricInterfaceStatusUpdateDto secureBiometricInterfaceDto);
}
