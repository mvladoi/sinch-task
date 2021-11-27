/*
 * Copyright 2018 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestBody
import java.util.*;

data class Message(val text: String, val priority: String)

@RestController
class MessageController {
    @RequestMapping(value = ["/sinch-assignment/all-pairs"], method = [RequestMethod.POST])
    fun pairs(@RequestBody data: String): String {

        //split the input string by new lines, and raise an exception if empty file
        var input: List<String>


        //this is just for safety, curl does not allow empty files
        try {
             input = data.split("\n")
        } catch (e: Exception) {
            return "The input file is empty"
        }
        
       
        //check if the input has the wright format
        if (input.size < 3){
            return "The input file requires at least 3 entries!"
        }
        


         //this is just for safety, curl does not allow empty files
         try {

        // init variables 
        val arr: List<Int> = input.map { it.toInt() }.toList()
        val sum : Int = arr.first()
        var hash:HashMap<Int,Int> = HashMap<Int,Int>()
        var count: Int = 0
        
        //loop over the input and find the number of pairs which make sum 
        for (i in 1.. arr.size-1) {
            //found one pair, increase the count
            if (hash.containsKey(sum - arr.elementAt(i))) {
                count += hash.getValue(sum - arr.elementAt(i))
            }

            // this is for duplicates entries 
            //if(hash.containsValue(arr.elementAt(i))){
                //hash.put(arr.elementAt(i), hash.getValue(arr.elementAt(i))+1);
            //}
            
            //no pair found, save the entry in hash for later
            else{
                hash.put(arr.elementAt(i), 1);
            }
        }
      
        //return number of pairs 
        return count.toString()
    }
     //check if the file has the corect format
     catch (e: Exception) {
        return "Malformat File"
     }


    }

    @RequestMapping(value = ["/sinch-assignment/polish-notation"], method = [RequestMethod.POST])
    fun polish(@RequestBody data: String): String {
        
        //split the input string by new lines, and raise an exception if empty file
        var input: List<String>


        //this is just for safety, curl does not allow empty files
        try {
             input = data.split("\n")
        } catch (e: Exception) {
            return "The input file is empty"
        }
        
       
        for (item in input) {
             print (item)
              
        }    


        //return number of pairs 
        return input.joinToString()

       }
    
}












import java.util.Stack
import java.util.Vector


fun isOperand (x: String): Boolean {
    if (x.equals("+") or x.equals("-") or x.equals("*") or x.equals("/") ){ 
       return false
    }    
    else {
       return true 
    }
            
} 

fun main(args: Array<String>){
    //print(isOperand(x))
    
    
    val input : List<String> = listOf("+ + 0.5 1.5 * 4 10", "- 2e3 - 700 + 7 * 2 15", "- -1.5 * 3.1415 / -7 -2", "100500", "1 2", "+ 1")
    val res: Vector<String> = Vector<String>();
    
    for (item in input){
   
        var stack : Stack<Double> = Stack()
        //val test: String = input[0]
        //print (test)
        val expr = input[0].split(" ")
        //print (expr.toString())
        
        for (i in (expr.size -1) downTo 0){
             if (isOperand(expr[i])){
                 stack.add(expr[i].toDouble())
             }
             
              else {
 
             
                val op1: Double = stack.peek()
                stack.pop()
                val op2: Double = stack.peek()
                stack.pop()
                
                when (expr[i]) {
                    
                   "+" -> stack.push(op1 + op2)
                   "-" -> stack.push(op1 - op2)
                   "*" -> stack.push(op1 * op2)
                   "/" -> stack.push(op1 / op2)
                   
                   
                   else -> { 
                      print("error")
                   }

                
               }
    
            }
              
             
      }
          res.addElement("%.2f".format(stack.peek()))
          
    } 
    
    for (item in res){
        print (item)
    }
    
}