import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { UserSkipTestsService } from '../user--skip-tests.service';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent {
  userFormGroup:any;

  constructor(private fb:FormBuilder, private service:UserSkipTestsService)
  {
    
    this.userFormGroup = fb.group({
      email:[],
      mobileNo:[],
      password:[],
      userAddress:[],
      userName:[],
      bankId:[],
      bankName:[],
      designation:[],
      branch:[],
      ifscCode:[],
      // setExcelFile:[]
    })
    
  }
  userfile:any;

  selectFile(event:any){
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
   //   this.userFormGroup.get("setExcelFile").setValue(file);
   this.userfile = file;
    }
  }
    sendData(){
      console.log("form grop  ",this.userFormGroup.value);

      let registretionData = this.userFormGroup.value;

      const formdata = new FormData();
      formdata.append("file", this.userfile);
      formdata.append("userData", JSON.stringify(registretionData))
      console.log("Form data ", formdata)
   
   
      this.service.sendDataWithFile(formdata).subscribe({
        next: (resp) => {
          alert("DATA HASE BEEN SAVED");
          console.log("Response----" + resp)
        },
        error: (err) => {
          console.log(err)
        }
      })
  
    
    }
}
