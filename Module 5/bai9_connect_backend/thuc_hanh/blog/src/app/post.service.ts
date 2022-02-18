import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IPost} from './post';
import {map} from 'rxjs/operators';

// @ts-ignore
@Injectable({
  providedIn: 'root'
})
export class PostService {
  private API_URL = 'http://jsonplaceholder.typicode.com/posts';
  constructor(
    // tslint:disable-next-line:variable-name
    private _httpClient: HttpClient
  ) { }
  // @ts-ignore
  getPosts(count = 10): Observable<IPost[]> {
    return this._httpClient.get<IPost[]>(this.API_URL).pipe(
      map(reponse => reponse.filter((post,i) => i<count))
    );
  }
  // @ts-ignore
  getPostById(id: number): Observable<IPost>{
    return this._httpClient.get<IPost>(`${this.API_URL}/${id}`)
  }
  // @ts-ignore
  createPost(post: Partial<IPost>): Observable<IPost>{
    return this._httpClient.post<IPost>(this.API_URL,post);
  }
  // @ts-ignore
  deletePost(id: number): Observable<any>{
    return this._httpClient.delete(`${this.API_URL}/${id}`);
  }
  // @ts-ignore
  editPost(post: IPost): Observable<IPost>{
    return this._httpClient.patch<IPost>(`${this.API_URL}/${post.id}`, post);
  }
}
