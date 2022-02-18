import { Component, OnInit } from '@angular/core';
import {IPost} from '../post';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {PostService} from '../post.service';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {
  postForm: FormGroup;
  postList: IPost[] = [];

  constructor(
    // tslint:disable-next-line:variable-name
    private _postService: PostService,
    // tslint:disable-next-line:variable-name
    private _formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    // @ts-ignore
    this.postForm = this._formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(10)]],
      body: ['', [Validators.required, Validators.minLength(10)]]
    });
    this._postService.getPosts().subscribe(
      next => (this.postList=next),error => (this.postList= [])
    )
  }

  onSubmit() {
    if( this.postForm.valid){
      const {value} = this.postForm;
      this._postService.createPost(value).subscribe(
        next => {
          this.postList.unshift(next);
          this.postForm.reset({title:'',body: ''})
        },error => console.log(error)
      );
    }
  }

  deletePost(i: number) {
    const post= this.postList[i];
    this._postService.deletePost(post.id).subscribe(
      ()=>{
        this.postList=this.postList.filter(t => t.id !==post.id)
      }
    )
  }
}
