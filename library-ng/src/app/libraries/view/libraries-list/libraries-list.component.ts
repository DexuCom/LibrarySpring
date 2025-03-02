import { Component, OnInit } from '@angular/core';
import { LibrariesService } from '../../service/libraries.service';
import { Library } from '../../model/library';

@Component({
  selector: 'app-libraries-list',
  templateUrl: './libraries-list.component.html',
  styleUrl: './libraries-list.component.css'
})
export class LibrariesListComponent implements OnInit{

  constructor(private service: LibrariesService) {}

  libraries: Library[] = [];

  ngOnInit(): void {
    this.service.getLibraries().subscribe((libraries) => this.libraries = libraries);
  }

  onDelete(library: Library): void {
    this.service.deleteLibrary(library.id).subscribe(() => this.ngOnInit());
  }
}
