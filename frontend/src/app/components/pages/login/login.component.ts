import {Component, inject} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {loginTypeObj} from '../../../models/types/login-type';
import {AuthService} from '../../../services/auth/auth.service';

@Component({
  selector: 'app-login',
  imports: [
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  authService = inject(AuthService);

  loginObj: loginTypeObj = {
    email: "",
    password: ""
  }

  onLoginSubmit (form: FormsModule) {
    this.authService.login(this.loginObj).subscribe({
      next: (res: any) => {
        localStorage.setItem("token", res.token)
        this.loginObj = {
          email: "",
          password: ""
        }
      },
      error: (err) => {
        console.log( err )
      }
    })
  }

}
