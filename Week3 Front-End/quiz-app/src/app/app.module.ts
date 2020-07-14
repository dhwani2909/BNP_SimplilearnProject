import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DisplayQuestionsComponent } from './display-questions/display-questions.component';
import { UserAnswersComponent } from './user-answers/user-answers.component';
import { ResultListComponent } from './result-list/result-list.component';
import { AttemptListComponent } from './attempt-list/attempt-list.component';
import { FormsModule } from '@angular/forms'
import { HttpClientModule } from '@angular/common/http';
import { QuizServiceService } from './quiz-service.service';

@NgModule({
  declarations: [
    AppComponent,
    DisplayQuestionsComponent,
    UserAnswersComponent,
    ResultListComponent,
    AttemptListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [QuizServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
