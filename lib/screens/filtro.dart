// ignore_for_file: prefer_const_constructors

import 'package:flutter/material.dart';

class Filtro extends StatefulWidget {
  const Filtro({Key? key}) : super(key: key);

  @override
  State<Filtro> createState() => _FiltroState();
}

class _FiltroState extends State<Filtro> {
  final ano = ['2022', '2021', '2020'];
  final materia = ['Matemática', 'Biologia', 'Portugues'];

  String? value;

  var value1;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SizedBox(
              height: 80,
            ),
            Row(
              children: [
                Container(
                  margin: EdgeInsets.only(left: 115),
                  child: Text('Ano:',
                      textScaleFactor: 1,
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 23.0,
                        fontWeight: FontWeight.w700,
                        color: Color.fromARGB(255, 41, 43, 35),
                      )),
                ),
                Container(
                  margin: EdgeInsets.fromLTRB(5, 1.6, 0, 0),
                  child: DropdownButtonHideUnderline(
                    child: DropdownButton<String>(
                      value: value,
                      items: ano.map(buildMenuItem).toList(),
                      onChanged: (value) => setState(() => this.value = value),
                    ),
                  ),
                ),
              ],
            ),
            Row(
              children: [
                Container(
                  margin: EdgeInsets.only(left: 79),
                  child: Text('Matriz:',
                      textScaleFactor: 1,
                      style: TextStyle(
                        fontFamily: 'Montserrat',
                        fontSize: 23.0,
                        fontWeight: FontWeight.w700,
                        color: Color.fromARGB(255, 41, 43, 35),
                      )),
                ),
                Container(
                  margin: EdgeInsets.fromLTRB(5, 1.6, 0, 0),
                  width: 160,
                  child: DropdownButtonHideUnderline(
                    child: DropdownButton<String>(
                      value: value1,
                      items: materia.map(buildMenuItem).toList(),
                      onChanged: (value1) =>
                          setState(() => this.value1 = value1),
                    ),
                  ),
                ),
              ],
            ),
            Padding(
              padding: const EdgeInsets.only(top: 30),
              child: SizedBox(
                width: 290,
                child: ElevatedButton(
                    onPressed: () {},
                    style: ButtonStyle(
                        backgroundColor: MaterialStateProperty.all<Color>(
                            Color(0xff40FD48))),
                    child: Text(
                      'Buscar',
                      style: TextStyle(
                          fontFamily: 'Montserrat',
                          fontSize: 17.0,
                          fontWeight: FontWeight.w900,
                          color: Color.fromARGB(255, 62, 66, 55)),
                    )),
              ),
            ),
          ],
        ),
      ),
    );
  }

  DropdownMenuItem<String> buildMenuItem(String item) => DropdownMenuItem(
        value: item,
        child: Text(
          item,
          textScaleFactor: 1,
          style: TextStyle(
            fontFamily: 'Montserrat',
            fontSize: 23.0,
            fontWeight: FontWeight.w700,
            color: Color.fromARGB(255, 41, 43, 35),
          ),
        ),
      );
}
