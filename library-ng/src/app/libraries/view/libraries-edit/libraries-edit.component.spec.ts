import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrariesEditComponent } from './libraries-edit.component';

describe('LibrariesEditComponent', () => {
  let component: LibrariesEditComponent;
  let fixture: ComponentFixture<LibrariesEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibrariesEditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LibrariesEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
