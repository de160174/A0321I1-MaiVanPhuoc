import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-information-animal',
  templateUrl: './information-animal.component.html',
  styleUrls: ['./information-animal.component.css']
})
export class InformationAnimalComponent implements OnInit {
  petName:String="puppie";
  petImg:String='http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg';
  constructor() { }

  ngOnInit(): void {
  }
  updateName(name) {
    this.petName = name;
  }

  updateImage(image) {
    this.petImg = image;
  }
}
