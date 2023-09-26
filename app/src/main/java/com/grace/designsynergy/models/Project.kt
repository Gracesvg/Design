package com.grace.designsynergy.models

class Project {
    var Projectdescription:String = ""
    var name:String = ""
    var phoneNo:String = ""
    var city:String = ""
    var email:String = ""
    var id:String=""


    constructor(name:String,Projectdescription:String,phoneNo:String,city:String,email:String,id:String){
        this.name =name
        this.Projectdescription =Projectdescription
        this.phoneNo =phoneNo
        this.city=city
        this.email=email
        this.id=id

    }
    constructor()
}
