import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  public products : any;

  public constructor(private http: HttpClient){}

  ngOnInit(): void {
   this.http.get("http://localhost:8082/api/products")
   .subscribe({
    next:data=>{
      this.products=data
    },
    error: err=>{
      console.log(err)
    }
   })
  }

}
