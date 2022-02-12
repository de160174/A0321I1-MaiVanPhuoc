import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';
interface IRatingUnit {
  value: number;
  active: boolean;
}
@Component({
  selector: 'app-rating-bar',
  templateUrl: './rating-bar.component.html',
  styleUrls: ['./rating-bar.component.css']
})
export class RatingBarComponent implements OnInit, OnChanges {
  @Input()
  showRatingValue= true;
  @Input()
  max= 10;
  @Input()
  ratingValue= 5;
  @Output()
  rateChange=new EventEmitter<number>();

  ratingUnits: Array<IRatingUnit>=[];

  constructor() { }

  ngOnChanges(changes: SimpleChanges){
    if('max' in changes){
      let max=changes.max.currentValue;
      max=typeof max==='undefined' ? 5 :max;
      this.max=max;
      this.calculate(max,this.ratingValue);
    }
  }

  ngOnInit(): void {
    this.calculate(this.max,this.ratingValue);
  }

  reset() {
    this.ratingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
  }

  select(i) {
    this.ratingValue=i+1;
    this.ratingUnits.forEach((item, idx) => item.active=idx<this.ratingValue);
    this.rateChange.emit(this.ratingValue);
  }

  enter(i) {
    this.ratingUnits.forEach((item, idx) => item.active = idx <= i);
  }

  calculate(max, ratingValue) {
    this.ratingUnits=Array.from({length:max},
      (_, index) => ({
        value:index+1,
        active: index<ratingValue
      }));
  }
}
