package com.in28minutes.rest.website.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {


	@GetMapping("/filtering")
	public SomeBean filtering(){
		return new SomeBean("value1", "value2", "value3");
	}

	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList(){
		return Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("v4","v5","v6"));
	}

	@GetMapping("/filtering-list-dynamic")
	public MappingJacksonValue filteringListDynamic(){
		SomeBeanWithDynamicFiltering someBean = new SomeBeanWithDynamicFiltering("v1","v2","v3");

		MappingJacksonValue mapping = new MappingJacksonValue(someBean); // 필터링을 추가할 수 있음
		PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		mapping.setFilters(filters);

		return mapping;

		// return Arrays.asList(new SomeBeanWithDynamicFiltering("value1", "value2", "value3"), new SomeBeanWithDynamicFiltering("v4","v5","v6"));

	}

	@GetMapping("/filtering-list-dynamic-test")
	public List<SomeBeanWithDynamicFiltering> filteringListDynamicTest(){
		SomeBeanWithDynamicFiltering someBean1 = new SomeBeanWithDynamicFiltering("v1", "v2", "v3");
		SomeBeanWithDynamicFiltering someBean2 = new SomeBeanWithDynamicFiltering("v4", "v5", "v6");

		MappingJacksonValue mapping1 = new MappingJacksonValue(someBean1);
		PropertyFilter filter1 = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters1 = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter1);
		mapping1.setFilters(filters1);

		// MappingJacksonValue mapping2 = new MappingJacksonValue(someBean2);
		// PropertyFilter filter2 = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		// FilterProvider filters2 = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter2);
		// mapping2.setFilters(filters2);

		// Logger.getLogger("mapping1",mapping1.toString());
		// Logger.getLogger("AsList",Arrays.asList(mapping1, mapping2).toString());

	return Arrays.asList(new SomeBeanWithDynamicFiltering("v1", "v2", "v3"));
		// return Arrays.asList(mapping1, mapping2);
		// return Arrays.asList(new SomeBeanWithDynamicFiltering("value1", "value2", "value3"), new SomeBeanWithDynamicFiltering("v4","v5","v6"));

	}

}
