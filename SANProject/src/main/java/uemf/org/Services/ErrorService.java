package uemf.org.Services;

import uemf.org.Models.ErrorDTO;

public interface ErrorService {

	ErrorDTO getErrorByCodeError(int codeError);
}
