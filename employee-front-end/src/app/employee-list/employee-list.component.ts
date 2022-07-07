import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Observable<Employee[]> | undefined;
  constructor(private employeeService: EmployeeService,
private router: Router ) {}

  ngOnInit(): void {
    this.reloadData();
    console.log(this.employees);
  }
  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
   
  }
  employeeDetails(id: number){
    this.router.navigate(['details', id]);
  }
  deleteEmployee(id: number) {
    this.employeeService.deleteEmployee(id)
      .subscribe();
        
  }
}
