import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrariesAddComponent } from './libraries-add.component';

describe('LibrariesAddComponent', () => {
  let component: LibrariesAddComponent;
  let fixture: ComponentFixture<LibrariesAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibrariesAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LibrariesAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
