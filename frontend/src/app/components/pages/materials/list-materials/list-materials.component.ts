import {Component, OnInit} from '@angular/core';
import {MaterialService} from '../../../../services/material.service';
import {Material} from '../../../../models/interfaces/material';

@Component({
  selector: 'app-list-materials',
  imports: [],
  templateUrl: './list-materials.component.html',
  styleUrl: './list-materials.component.css'
})

export class ListMaterialsComponent implements OnInit {
  materials: Material[] = [];

  constructor(private materialService: MaterialService) {}

  ngOnInit(): void {
    this.materialService.getMaterials().subscribe((data) => {
      this.materials = data;
    });
  }

}
