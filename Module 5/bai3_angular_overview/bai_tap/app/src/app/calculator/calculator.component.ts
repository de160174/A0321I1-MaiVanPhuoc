import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  output:number;
  first:number;
  second:number;
  operator ='+';
  constructor() { }

  ngOnInit(): void {
  }

  onFirstChange(value) {
    this.first=Number(value);
  }

  onSelectChange(value: any) {
    this.operator=value;
  }

  calculate() {
    switch (this.operator) {
      case '+':
        this.output = this.first + this.second;
        break;
      case '-':
        this.output = this.first - this.second;
        break;
      case '*':
        this.output = this.first * this.second;
        break;
      case '/':
        this.output = this.first / this.second;
        break;
    }
  }

  onSecondChange(value: any) {
    this.second=Number(value);
  }
}
