package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.CarRequest;
import kea.sem3.jwtdemo.dto.CarResponse;
import kea.sem3.jwtdemo.entity.Car;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> getCars(){
        List<Car> cars = carRepository.findAll();
        return CarResponse.getCarsFromEntities(cars);
    }
    public CarResponse getCar(int id,boolean all) throws Exception {
        CarResponse response = new CarResponse(carRepository.findById(id).orElseThrow(() ->new Client4xxException("no car with this id")), false);
        return response;
    }
    public CarResponse addCar(CarRequest body){
        Car carNew = carRepository.save(new Car(body));
        return new CarResponse(carNew,true);
    }
    public CarResponse editCar(CarRequest body, int id){
        Car car = carRepository.findById(id).orElseThrow(() -> new Client4xxException("no car with this id"));
        car.setBrand(body.getBrand());
        car.setModel(body.getModel());
        car.setPricePrDay(body.getPricePrDay());
        car.setDiscount(body.getBestDiscount());

        carRepository.save(car);
        return new CarResponse(car,true);
    }

    public void deleteCar(int id) {
        carRepository.delete(carRepository.getById(id));
        System.out.println("car deleted ID: " + id);
    }
}
