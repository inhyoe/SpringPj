package com.in28minutes.rest.website.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * content negotiation
 * 콘텐츠 협상
 * 다양한 방법으로 버전을 관리하려는 경우
 */
@RestController
public class VersioningPersonController {
	@GetMapping("/v1/person")
	public PersonV1 getPerson() {
		return new PersonV1("Ingyoe");
	}

	@GetMapping("/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Ingype", "Man"));
	}

	/**
	 * 쿼리스트링을 이용한 방법
	 * @return
	 */
	@GetMapping(path = "/person", params = "verson=1")
	public PersonV1 getPersonV1s() {
		return new PersonV1("ingyoe");
	}

	@GetMapping(path = "/person", params = "verson=2")
	public PersonV2 getPersonV2s() {
		return new PersonV2(new Name("Ingype", "Man"));
	}

	/**
	 * 헤더를 이용한 방법
	 * @return
	 */
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getPersonV1RequestHeader() {
		return new PersonV1("ingyoe");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getPersonV2RequestHeader() {
		return new PersonV2(new Name("Ingype", "Man"));
	}

	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getPersonV2AcceptHeader() {
		return new PersonV2(new Name("Ingype", "Man"));
	}

}
