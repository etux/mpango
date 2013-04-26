package net.sf.mpango.game.web.adapter;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import net.sf.mpango.game.web.dto.CityDTO;
import net.sf.mpango.game.core.entity.City;
import net.sf.mpango.game.core.enums.ConstructionType;
import net.sf.mpango.game.web.adapter.CityAdapter;
import net.sf.mpango.game.web.TestUtils;

import org.junit.Assert;
import org.junit.Test;

public class ConstructionAdapterTest extends TestCase {

	@Test
	public void testCityBuilder() {
		City city = TestUtils.getCity(1L);
		CityDTO dto = CityAdapter.instance().toDTO(city);
		Assert.assertNotNull(city);
		Assert.assertEquals(dto.getType(), ConstructionType.CITY);
	}

	@Test
	public void testCityBuilderList() {
		List<City> cityList = new ArrayList<City>();
		cityList.add(TestUtils.getCity(1L));
		cityList.add(TestUtils.getCity(2L));
		cityList.add(TestUtils.getCity(3L));
		cityList.add(TestUtils.getCity(4L));
		cityList.add(TestUtils.getCity(5L));
		List<CityDTO> dtoList = CityAdapter.instance().toDTOList(cityList);
		Assert.assertNotNull(dtoList);
		Assert.assertEquals(dtoList.size(), 5);
	}

	@Test
	public void testCityFactory() {
		CityDTO dto = TestUtils.getCityDTO(1L);
		
		City city = CityAdapter.instance().fromDTO(dto);
		Assert.assertNotNull(city);
		Assert.assertEquals(city.getType(), ConstructionType.CITY);
	}
	
	@Test
	public void testCityFactoryList() {
		List<CityDTO> dtoList = new ArrayList<CityDTO>();
		dtoList.add(TestUtils.getCityDTO(1L));
		dtoList.add(TestUtils.getCityDTO(2L));
		dtoList.add(TestUtils.getCityDTO(3L));
		dtoList.add(TestUtils.getCityDTO(4L));
		dtoList.add(TestUtils.getCityDTO(5L));
		List<City> cityList = CityAdapter.instance().fromDTOList(dtoList);
		Assert.assertNotNull(cityList);
		Assert.assertEquals(cityList.size(), 5);
	}
}