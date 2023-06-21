<?php

namespace App\Http\Controllers;

use App\Models\stagiare;
use Illuminate\Http\Request;

class StagiareController extends Controller
{
    public function index(){
        $Stagiare = stagiare ::all();
        return $Stagiare;
    }


public function filter (Request $request,$name_prenom){

         $filter = stagiare::where('Nom', 'like', '%' . $name_prenom . '%')
                ->orWhere('Prenom', 'like', '%'.$name_prenom.'%')
                ->get();
                if($filter->count()>=1){
                    return response()->json([
                        'message' => "existe"
                    ]);
                }
                else{
                    return response()->json([
                        'message' => "n'extest pas"
                    ]);
                }   
}


}