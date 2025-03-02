import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrariesListComponent } from './libraries-list.component';

describe('LibrariesListComponent', () => {
  let component: LibrariesListComponent;
  let fixture: ComponentFixture<LibrariesListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LibrariesListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LibrariesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
