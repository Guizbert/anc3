# ANC3 2223 - Farming Project
## Overview

ANC3 is a small game developed using JavaFX for school with my friend Kenji.

In this game, you control a farmer who can be moved using the arrow keys or by clicking anywhere on the screen. At the top of the screen, you can see important information such as your score, the number of days passed, and the number of seeds you have (note: seeds were an integral part of the exam). Sleeping is a crucial mechanic in the game; after planting an item, you must sleep to allow it to grow and update.
![image](https://github.com/user-attachments/assets/807c7e66-82e5-4a26-ab10-4539cc276e77)

Features

- Planting: You can plant various items such as grass, carrots, or cabbage. (The 'yellow' element was added while studying for the exam, so it can be ignored.)
![image](https://github.com/user-attachments/assets/6a57a7ac-999f-477e-9b51-ff712a19820d)

- Growth Mechanics: To make a cabbage grow faster, plant it on grass. For carrots, you can use fertilizer to instantly grow them to stage 3.
![image](https://github.com/user-attachments/assets/d7a67547-977b-46ce-8e15-82b587000fcc)

- Scoring: Harvesting a fully grown carrot rewards you with 100 points.
![image](https://github.com/user-attachments/assets/acdd52e2-7332-4281-a1e0-2e3c5cf408b1)

- Harvesting a fully grown cabbage rewards you with 200 points.
![image](https://github.com/user-attachments/assets/730c37bc-04cb-4f26-9d1d-6131e9109f47)

- Rotting Mechanic: As shown in the screenshot above, if you wait too long to harvest your crops, they will start to rot. Once in a rotten state, harvesting will result in a loss of points. The longer you wait, the more points you will lose.
    
        points_lost = 1/10 * maximum_yield * (harvest_day - first_day_of_rotting_stage)
- Refer to: Diagrammes/Diagramme_etat_chou.png and Diagrammes/Diagramme_etat_carrot.png.



### Performance

    Exam Grade: 92%
    Final Grade: 75%
