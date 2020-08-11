import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders, HttpEvent } from '@angular/common/http';
import { Company } from '../app/models/company';

const options= {
  headers: new HttpHeaders({'content-type': 'application/json'})

}
@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  url : string = "http://localhost:8080/api/users/add"
  link: string ="http://localhost:8080/api/company"
  com1 : string = "http://localhost:8080/api/company/add"
  constructor(private http: HttpClient) { }

  public addUser(name: String, mnumber: String, email: String, password: String) {
    console.log("Service Done");

    return this.http.post<any>(this.url,{"name":name,"mnumber":mnumber,"email":email,"password":password},options);

  }

  //public addCompany(c_name: String, t_over: String ,ceo: String , director: String , stock: String,sector: String,descr: String ,s_code: String ) {

    //console.log("New Company Created");
    //return this.http.post<any>(this.com1,{"c_name":c_name,"t_over":t_over, "ceo":ceo, "director":director,
      //"stock":stock, "sector":sector, "descr":descr, "s_code":s_code},options);
    //subscribe(data => {console.log("success");},error => {console.log("error",error);});

  //}
  public addCompany(comp: any ) {

    return this.http.post<any>(this.com1,comp,options);
    //subscribe(data => {console.log("success");},error => {console.log("error",error);});

  }

  public checkAdmin(credentials : any) {
    return this.http.post<any>("http://localhost:8080/api/users/checkadmin",credentials, {responseType: 'text' as 'json'});
    //subscribe(data => {console.log("success");},error => {console.log("error",error);});

  }
  public getCompany(){
    console.log("Company Created");
    return this.http.get<Company[]>(this.link)
  }
  public editCompany(comp: Company){
    return this.http.put<Company[]>("http://localhost:8080/api/company/update",comp)
  }

  public deleteCompany(comp: Company){
    return this.http.delete<Company[]>("http://localhost:8080/api/company/cancel/byid/"+comp.id)
  }

  public pushFile(file: File){
    const data: FormData = new FormData();
    data.append('file', file);
    return this.http.post<HttpEvent<{}>>("http://localhost:8080/api/file",data,{
      reportProgress: true,
      responseType: 'text' as 'json'
      })
  }

}
