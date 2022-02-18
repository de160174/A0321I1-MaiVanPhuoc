import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {PostService} from '../post.service';
import {IPost} from '../post';

@Component({
  selector: 'app-blog-edit',
  templateUrl: './blog-edit.component.html',
  styleUrls: ['./blog-edit.component.css']
})
export class BlogEditComponent implements OnInit {
  postForm: FormGroup;
  post: IPost;

  constructor(
    private _route: ActivatedRoute,
    private _postService: PostService,
    private _formBuilder: FormBuilder,
    private _router: Router
  ) { }

  ngOnInit(): void {
    this.postForm= this._formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(10)]],
      body: ['', [Validators.required, Validators.minLength(10)]]
    });
    const id= +this._route.snapshot.paramMap.get('id');
    this._postService.getPostById(id).subscribe(
      next => {
        this.post=next;
        this.postForm.patchValue(this.post)
      },
      error => {
        console.log(error);
        this.post= null;
      }
    )
  }

  onSubmit() {
    if (this.postForm.valid){
      const {value} =this.postForm;
      const data={
        ...this.post,
        ...value
      };
      this._postService.editPost(data).subscribe(
        next => {this._router.navigate(['/blog']);},
        error => console.log(error)
      )
    }
  }
}
