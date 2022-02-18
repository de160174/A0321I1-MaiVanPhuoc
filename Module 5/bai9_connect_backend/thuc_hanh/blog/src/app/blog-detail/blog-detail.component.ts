import { Component, OnInit } from '@angular/core';
import {IPost} from '../post';
import {ActivatedRoute} from '@angular/router';
import {PostService} from '../post.service';

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.css']
})
export class BlogDetailComponent implements OnInit {
  post: IPost;

  constructor(
    private _route: ActivatedRoute,
    private _postService: PostService
  ) { }

  ngOnInit(): void {
    const id= +this._route.snapshot.paramMap.get('id');
    this._postService.getPostById(id).subscribe(
      next => (this.post=next),
      error => {
        console.log(error);
        this.post=null;
      }
    )
  }

}
