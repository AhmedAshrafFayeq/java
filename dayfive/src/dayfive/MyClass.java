package dayfive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.lang.Comparable;
import dayfive.*;
import dayfive.*;
import  java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

class MyClass{
	
	public static void main(String []args)
	{
		InMemoryWorldDao data =InMemoryWorldDao.getInstance();
                List<Country> countries=data.findAllCountries();
                countries.stream().forEach(myCountry->{
                    List <City> cities =myCountry.getCities();
                    City maxCity =cities.stream().max((x,y)-> x.getPopulation()-y.getPopulation()).orElse(null);
                    
                    if (maxCity!=null)
                    {
                        System.out.println(maxCity.getName());
                    }
                    
                });
                System.out.println("*******************************");
                List<City> cites=new ArrayList<>();
                
                List<Integer> capitalsId=countries.stream().map(myCountry -> myCountry.getCapital()).collect(toList());
                capitalsId.stream().forEach(capital->{
                    City tempCity=data.findCityById(capital);
                    if(tempCity !=null)
                    {
                        cites.add(tempCity);
                    }
                });
                City maxCity=cites.stream().max((x,y)->x.getPopulation()-y.getPopulation()).get();
                if (maxCity!=null)
                {
                    System.out.println(maxCity.getName());
                }
                System.out.println("###############################");
                Set <String> continents=data.getAllContinents();
                
                continents.stream().forEach(continent->{
                    List<Country> new_countries=data.findCountriesByContinent(continent);
                    List<City> max_cities=new ArrayList<>();
                    
                    new_countries.stream().forEach(country->{
                        List <City> countryCity=data.findCitiesByCountryCode(country.getCode());
                        City MaxCity=countryCity.stream().max( (x,y)->x.getPopulation()-y.getPopulation() ).orElse(null) ;
                        if (MaxCity!=null)
                        {
                            max_cities.add(MaxCity);
                        }  
                    });
                    City largest_city =max_cities.stream().max((x,y)-> x.getPopulation()-y.getPopulation() ).orElse(null);
                    if (largest_city != null)
                    {
                        System.out.println(largest_city.getName());
                    }
                    
                });
                
                
                
                
                
	}
}