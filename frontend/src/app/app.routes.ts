import { Routes } from '@angular/router';
import {LoginComponent} from './components/pages/login/login.component';
import {LayoutComponent} from './components/layouts/layout/layout.component';
import {DashboardComponent} from './components/pages/dashboard/dashboard.component';
import {ListMaterialsComponent} from './components/pages/materials/list-materials/list-materials.component';


export const routes: Routes = [
  {
    path: "",
    component: LoginComponent
  },
  {
    path: "app",
    component: LayoutComponent,
    children: [
      {
        path: "dashboard",
        component: DashboardComponent
      },
      {
        path: "materials",
        component: ListMaterialsComponent
      }
    ]
  },
];
