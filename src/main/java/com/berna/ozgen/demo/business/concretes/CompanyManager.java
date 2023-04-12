package com.berna.ozgen.demo.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.berna.ozgen.demo.business.abstracts.CompanyService;
import com.berna.ozgen.demo.business.constants.Messages;
import com.berna.ozgen.demo.business.requests.creates.CreateCompanyRequest;
import com.berna.ozgen.demo.business.requests.updates.UpdateCompanyRequest;
import com.berna.ozgen.demo.business.responses.creates.CreateCompanyResponse;
import com.berna.ozgen.demo.business.responses.get.companies.GetAllCompanyResponse;
import com.berna.ozgen.demo.business.responses.get.companies.GetByCompanyResponse;
import com.berna.ozgen.demo.business.responses.updates.UpdateCompanyResponse;
import com.berna.ozgen.demo.dataAccess.abstracts.CompanyRepository;
import com.berna.ozgen.demo.entities.Company;
import com.kodlamaio.common.utilities.exceptions.BusinessException;
import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.common.utilities.results.DataResult;
import com.kodlamaio.common.utilities.results.Result;
import com.kodlamaio.common.utilities.results.SuccessDataResult;
import com.kodlamaio.common.utilities.results.SuccessResult;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {
	private CompanyRepository companyRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateCompanyResponse> add(CreateCompanyRequest createCompanyRequest) {
		checkByCompanyName(createCompanyRequest.getCompanyName());  //isim kontrolü yaptı
		Company company = this.modelMapperService.forRequest().map(createCompanyRequest, Company.class);
		this.companyRepository.save(company); // veritabanına kayıt edildi

		CreateCompanyResponse createCompanyResponse = this.modelMapperService.forResponse().map(company,
				CreateCompanyResponse.class);

		return new SuccessDataResult<CreateCompanyResponse>(createCompanyResponse, Messages.CompanyCreated);
	}

	@Override
	public DataResult<UpdateCompanyResponse> update(UpdateCompanyRequest updateCompanyRequest) {
		checkIfCompanyId(updateCompanyRequest.getCompanyId());  //id kontrolü yapıldı
		checkByCompanyName(updateCompanyRequest.getCompanyName()); //isim kontrolü yapıldı
		Company company = this.modelMapperService.forRequest().map(updateCompanyRequest, Company.class);
		this.companyRepository.save(company); // güncelleme kaydedildi
		UpdateCompanyResponse updateCompanyResponse = this.modelMapperService.forResponse().map(company,
				UpdateCompanyResponse.class);
		return new SuccessDataResult<UpdateCompanyResponse>(updateCompanyResponse, Messages.CompanyUpdated);
	}

	@Override
	public Result delete(int companyId) {
		checkIfCompanyId(companyId);
		this.companyRepository.deleteById(companyId);
		return new SuccessResult(Messages.CompanyDeleted);
	}

	@Override
	public DataResult<List<GetAllCompanyResponse>> getAll() {
		List<Company> companies = this.companyRepository.findAll();
		List<GetAllCompanyResponse> getAllCompanyResponses = companies.stream()
				.map(company -> this.modelMapperService.forResponse().map(company, GetAllCompanyResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllCompanyResponse>>(getAllCompanyResponses, Messages.CompanyListed);
	}

	@Override
	public DataResult<GetByCompanyResponse> getByCompany(int companyId) {
		checkIfCompanyId(companyId);
		Company company = this.companyRepository.findById(companyId);
		GetByCompanyResponse getByCompanyResponse = this.modelMapperService.forResponse().map(company,
				GetByCompanyResponse.class);
		return new SuccessDataResult<GetByCompanyResponse>(getByCompanyResponse, Messages.CompanyListed);
	}

	private void checkIfCompanyId(int companyId) { // id kontrolü yaptırıyor
		Company company = this.companyRepository.findById(companyId);
		if (company == null) {
			throw new BusinessException(Messages.CompanyExists);
		}
	}

	private void checkByCompanyName(String companyName) { //aynı isimde şirket kaydedilmesini engelliyor
		Company company = this.companyRepository.getByCompanyName(companyName);
		if (company != null) {
			throw new BusinessException(Messages.CompanyNameExists);
		}
	}

}
