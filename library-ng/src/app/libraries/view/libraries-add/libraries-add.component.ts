import { Component, OnInit } from '@angular/core';
import { LibraryEdit } from '../../model/library-edit';
import { LibrariesService } from '../../service/libraries.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-libraries-add',
  templateUrl: './libraries-add.component.html',
  styleUrl: './libraries-add.component.css'
})
export class LibrariesAddComponent implements OnInit{

  library: LibraryEdit | undefined;
  original: LibraryEdit | undefined;

  constructor(
    private libraryService: LibrariesService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void{
    this.library = {name: ''};
    this.original = {...this.library};
  }
  
  onSubmit(): void {
    console.log(this.library);
    this.libraryService.addLibrary(this.library!)
      .subscribe(() => this.router.navigate(['/libraries']));
  }
}

