import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMaterialsComponent } from './list-materials.component';

describe('ListMaterialsComponent', () => {
  let component: ListMaterialsComponent;
  let fixture: ComponentFixture<ListMaterialsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListMaterialsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListMaterialsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
