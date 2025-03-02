import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrariesDetailsComponent } from './libraries-details.component';

describe('LibrariesDetailsComponent', () => {
  let component: LibrariesDetailsComponent;
  let fixture: ComponentFixture<LibrariesDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibrariesDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LibrariesDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
