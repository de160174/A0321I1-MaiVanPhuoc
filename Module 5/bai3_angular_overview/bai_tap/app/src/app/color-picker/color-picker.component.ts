import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {
  background='#333';
  constructor() { }

  ngOnInit(): void {
  }

  onChange(value: any) {
    this.background=value;
  }
}
