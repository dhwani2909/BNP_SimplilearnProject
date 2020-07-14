import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AttemptListComponent } from './attempt-list/attempt-list.component';
import { DisplayQuestionsComponent } from './display-questions/display-questions.component';
import { ResultListComponent } from './result-list/result-list.component';
import { UserAnswersComponent } from './user-answers/user-answers.component';


const routes: Routes = [
  {path: 'displayAttempts', component:AttemptListComponent},
  {path: 'questionList', component:DisplayQuestionsComponent},
  {path: 'displayResult', component:ResultListComponent},
  {path: 'getUserAnswer', component:UserAnswersComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
