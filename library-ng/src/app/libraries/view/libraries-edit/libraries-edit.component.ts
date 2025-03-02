import { Component, OnInit } from '@angular/core';
import { LibraryEdit } from '../../model/library-edit';
import { LibrariesService } from '../../service/libraries.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-libraries-edit',
  templateUrl: './libraries-edit.component.html',
  styleUrl: './libraries-edit.component.css'
})
export class LibrariesEditComponent implements OnInit{

  uuid: string | undefined;
  library: LibraryEdit | undefined;
  original: LibraryEdit | undefined;

  constructor(
    private libraryService: LibrariesService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.libraryService.getLibrary(params['uuid'])
        .subscribe(library => {
          this.uuid = library.id;
          this.library = {
            name: library.name
          };
          this.original = {...this.library};
        });
    });
  }
  
  onSubmit(): void {
    this.libraryService.putLibrary(this.uuid!, this.library!)
      .subscribe(() => this.router.navigate(['/libraries']));
  }
}
