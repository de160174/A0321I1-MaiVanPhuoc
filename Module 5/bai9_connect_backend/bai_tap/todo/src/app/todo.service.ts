import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ITodo} from "./todo";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private API_URL = 'http://jsonplaceholder.typicode.com/todos';

  constructor(private _http: HttpClient) { }
  getTodos(count=10): Observable<ITodo[]>{
    return this._http.get<ITodo[]>(this.API_URL).pipe(
      map(reponse => reponse.filter((todo, i) => i<count))
    )
  }
  getTodoById(id: number): Observable<ITodo>{
    return this._http.get<ITodo>(`${this.API_URL}/${id}`);
  }
  createTodo(todo: Partial<ITodo>): Observable<ITodo>{
    return this._http.post<ITodo>(this.API_URL, todo);
  }
  deleteTodo(id: number): Observable<ITodo>{
    return this._http.delete<ITodo>(`${this.API_URL}/${id}`);
  }
  updateTodo(todo: ITodo): Observable<ITodo>{
    return this._http.patch<ITodo>(`${this.API_URL}/${todo.id}`, todo);
  }
}
