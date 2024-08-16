import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'front-end-angular';
  public profile:any;
  constructor(public keycloakService: KeycloakService){
    
  }
  ngOnInit(): void {
    //si l'utilisateur est connecté je charge le profil de l'utilisateur
    if(this.keycloakService.isLoggedIn()){
      this.keycloakService.loadUserProfile().then(profile=>{
        this.profile=profile;
      })
    }
  }

  logout(){
    this.keycloakService.logout(window.location.origin); //on specifi en parametre l'origine
  }

  async onLogin(){
   await this.keycloakService.login({
    redirectUri: window.location.origin
   });
  }
}
