<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class stagiare extends Model
{
    use HasFactory;

    

    protected $table = "stagiare";
    public $timestamps= false;
    protected $fillable = [

        "Nom",
        "Prenom",
       
    ]; 
}
