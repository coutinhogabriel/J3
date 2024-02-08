// formulario.component.ts
import { Component } from '@angular/core';
import { Usuario } from '../model/usuario.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css'],
  standalone: true,
  imports: [FormsModule]
})
export class FormularioComponent {
  usuario: Usuario = {
    nome: '', email: ''
  };

  onSubmit() {
    // Aqui, você pode armazenar os dados em um arquivo JSON
    // Por exemplo, usando o serviço HttpClient ou
    localStorage
    console.log('Dados do usuário:', this.usuario);
  }
}