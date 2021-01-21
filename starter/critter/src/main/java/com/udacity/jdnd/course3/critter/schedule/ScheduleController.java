package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.entity.Customer;
import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.entity.Pet;
import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.pet.PetType;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.critter.service.CustomerService;
import com.udacity.jdnd.course3.critter.service.EmployeeService;
import com.udacity.jdnd.course3.critter.service.PetService;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import com.udacity.jdnd.course3.critter.service.impl.CustomerServiceImpl;
import com.udacity.jdnd.course3.critter.service.impl.EmployeeServiceImpl;
import com.udacity.jdnd.course3.critter.service.impl.PetServiceImpl;
import com.udacity.jdnd.course3.critter.service.impl.ScheduleServiceImpl;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    CustomerService customerService;
    EmployeeService employeeService;
    PetService petService;
    ScheduleService scheduleService;

    public ScheduleController(CustomerService customerService, EmployeeService employeeService, PetService petService, ScheduleService scheduleService) {
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.petService = petService;
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = this.scheduleService.saveSchedule(convertScheduleDTOtoEntity(scheduleDTO));
        return convertEntitytoScheduleDTO(schedule);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> scheduleList = scheduleService.getAllSchedules();
        return scheduleList.stream().map(x->convertEntitytoScheduleDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
//        throw new UnsupportedOperationException();
        List <Schedule> scheduleList = scheduleService.getSchedulesForPet(petId);
        return scheduleList.stream().map(x->convertEntitytoScheduleDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List <Schedule> scheduleList = scheduleService.getScheduleForEmployee(employeeId);
        return scheduleList.stream().map(x->convertEntitytoScheduleDTO(x)).collect(Collectors.toList());
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List <Schedule> scheduleList = scheduleService.getScheduleForCustomer(customerId);
        return scheduleList.stream().map(x->convertEntitytoScheduleDTO(x)).collect(Collectors.toList());
    }

    private Schedule convertScheduleDTOtoEntity(ScheduleDTO scheduleDTO){
        Set<EmployeeSkill> activities= scheduleDTO.getActivities();
        LocalDate date = scheduleDTO.getDate();
        List<Employee> employeeList = scheduleDTO.getEmployeeIds().stream().map(x-> employeeService.getEmployeeById(x)).collect(Collectors.toList());
        List<Pet> petList = scheduleDTO.getPetIds().stream().map(x->petService.getPetById(x)).collect(Collectors.toList());
        return new Schedule(activities,date,employeeList,petList);
    }
    private ScheduleDTO convertEntitytoScheduleDTO(Schedule schedule){
        Set<EmployeeSkill>activities = schedule.getActivities();
        LocalDate date = schedule.getDate();
        List<Long>petIds= schedule.getPets().stream().map(x->petService.getPetIdByName(x.getName())).collect(Collectors.toList());
        List<Long> employeeIds= schedule.getEmployees().stream().map(x->employeeService.getEmployeeIdbyName(x.getName())).collect(Collectors.toList());
        return new ScheduleDTO(employeeIds,petIds,date,activities);
    }
}
