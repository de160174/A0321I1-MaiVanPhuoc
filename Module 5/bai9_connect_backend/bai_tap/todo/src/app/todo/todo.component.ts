import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {ITodo} from "../todo";
import {TodoService} from "../todo.service";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  input= new FormControl();
  todoList: ITodo[]= [];

  constructor(private _todoService: TodoService) { }

  ngOnInit(): void {
    this._todoService.getTodos().subscribe(
      next => {this.todoList = next},
      error => console.log(error),
      () => console.log('complete')
    )
  }

  addTodo() {
    const todo: Partial<ITodo> = {
      title: this.input.value,
      complete: false
    };
    this._todoService.createTodo(todo).subscribe(
      next => {
        this.todoList.unshift(next);
        this.input.setValue('');
      }
    )
  }

  toggleTodo(i: number) {
    const todo = this.todoList[i];
    const todoData = {
      ...todo,
      complete: !todo.complete
    };
    this._todoService.updateTodo(todoData).subscribe(
      next => {this.todoList[i].complete= next.complete}
    )
  }

  deleteTodo(i: number) {
    const todo = this.todoList[i];
    this._todoService.deleteTodo(todo.id).subscribe(
      () => {
        this.todoList = this.todoList.filter(t => t.id !== todo.id);
      })
  }
}
