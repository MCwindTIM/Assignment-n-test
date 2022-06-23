#include <stdio.h> // printf, scanf, NULL, fgets, fputs, fflush, fopen, fclose, etc
#include <string.h> // strlen, strstr, etc
#include <stdlib.h> // malloc, free, exit, etc


//struct for a contact
struct contact{
    int pK;
    char phoneNumber[20];
    char name[20],company[20],email[30];

} list;

FILE *fp, *ft;

//searchWord is the word that is being searched for
char searchWord[20];
//i is for looping
//no is for storing user selected No. to search contact with that No.
//f is a value to state if searchWord/No. is matched one/any contact or not (1 = true, 0 = false)
int i, no, f;


int main() {

    while (1) {
        system("cls");
        printf("Welcome to Coffee Contacts!\n");
        printf("Please input\nl - show all contacts\na - add a new contact\nm - modify a contact\nd - delete a contact\ns - search a contact by name\nq - quit the program\n");
        char command[100];
        fflush(stdin);
        scanf("%s", command);

        switch (command[0]) {
            case 'l':
                system("cls");
                //reset i
                i = 0;
                printf("\nNo.\t\t\tName\t\t\tCompany\t\t\tPhone\t\t\tEmail");
                fp = fopen("contactsData.dat","r");
                //list all contacts in the file by ascending order (using pK)
                while(fread(&list, sizeof(list), 1, fp)){
                    for(i = 0; i < 100; i++){
                        if(i == list.pK){
                            printf("\n%d\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s", i, list.name, list.company, list.phoneNumber, list.email);
                        }
                    }
                }
                fclose(fp);
                //press any key to continue
                printf("\nPress any key to continue...");
                getch();
                
                break;
            case 'a':
                //get biggest pK number from contactsData.dat
                fp = fopen("contactsData.dat", "r");
                //reset i
                i = 0;
                while (fread(&list, sizeof(list), 1, fp) == 1) {
                    if (list.pK > i) {
                        i = list.pK;
                    }
                }
                fclose(fp);

                fp = fopen("contactsData.dat", "a");
                fflush(stdin);
                printf("Please input the Name: ");
                scanf("%[^\n]", &list.name);
                fflush(stdin);
                printf("Please input the Company: ");
                scanf("%[^\n]", &list.company);
                fflush(stdin);
                printf("Please input the Phone: ");
                scanf("%[^\n]", &list.phoneNumber);
                fflush(stdin);
                printf("Please input the E-mail: ");
                gets(list.email);
                list.pK = i + 1;
                printf("\n");
                fwrite(&list, sizeof(list), 1, fp);
                fclose(fp);

                printf("Contact added!");
                //press any key to continue
                getch();
                break;
            case 'm':
                f = 0;
                system("cls");
                fp=fopen("contactsData.dat","r");
                ft=fopen("temp.dat","w");
                fflush(stdin);
                printf("Please input the No. of the contact to modify: ");
                scanf("%d",&no);
                while(fread(&list,sizeof(list),1,fp)!=0){
                    if (no != list.pK){
                        fwrite(&list,sizeof(list),1,ft);
                    }
                    else{
                        f = 1;
                        fflush(stdin);
                        printf("Please input the Name: ");
                        scanf("%[^\n]", &list.name);
                        fflush(stdin);
                        printf("Please input the Company: ");
                        scanf("%[^\n]", &list.company);
                        fflush(stdin);
                        printf("Please input the Phone: ");
                        scanf("%[^\n]", &list.phoneNumber);
                        fflush(stdin);
                        printf("Please input the E-mail: ");
                        gets(list.email);
                        list.pK = no;
                        fwrite(&list,sizeof(list),1,ft);
                        printf("Contact updated!");
                    }
                }
                fclose(fp);
                fclose(ft);
                //if not found any contact with the No., that means no contact is modified and the file is not changed
                if(f == 0){
                    //remove the temp.dat file
                    remove("temp.dat");
                    printf("Contact not found!");
                }else{
                    //file has been modified, so delete the old file and rename the temp file to contactsData.dat
                    remove("contactsData.dat");
                    rename("temp.dat","contactsData.dat");
                }
                getch();
                break;
            case 'd':
                f = 0;
                system("cls");
                fflush(stdin);
                printf("Please input the No. of the contact to delete: ");
                scanf("%d",&no);
                fp=fopen("contactsData.dat","r");
                ft=fopen("temp.dat","w");
                while(fread(&list,sizeof(list),1,fp)!=0){
                    if (no != list.pK){
                        fwrite(&list,sizeof(list),1,ft);
                    }else{
                        printf("Contact deleted!");
                        f = 1;
                    }
                }
                if(f == 0){
                    printf("Contact not found!");
                }
                fclose(fp);
                fclose(ft);
                remove("contactsData.dat");
                rename("temp.dat","contactsData.dat");
                //press any key to continue
                getch();
                break;

            case 's':
                f = 0;
                system("cls");
                printf("Please input the name of the contact to search: ");
                fflush(stdin);
                scanf("%[^\n]", &searchWord);
                fp = fopen("contactsData.dat", "r");
                fflush(stdin);
                while (fread(&list, sizeof(list), 1, fp) == 1) {
                    //if list.name contains searchWord (Bonus: Support search with partial names)
                    if (strstr(list.name, searchWord) != NULL) {
                        //print out "Contact found: " when first result is found (only print out once)
                        if(f == 0){
                            printf("Contact found: ");
                        }
                        printf("\n%d\t\t\t%s\t\t\t%s\t\t\t%s\t\t\t%s", list.pK, list.name, list.company, list.phoneNumber, list.email);
                        f = 1;
                    }
                    ////if contact name match searchWord
                    // if (strcmp(list.name, searchWord) == 0) {
                    //     printf("Contact found: ");
                    //     printf("\n\t> %d\t%s\t%s\t%s\t%s", list.pK, list.name, list.company, list.phoneNumber, list.email);
                    //     f = 1;
                    // }
                }
                if(f == 0){
                    printf("Contact not found!");
                }
                //press any key to continue
                getch();
                break;
            case 'q':
                printf("Quit the program\n");
                exit(0);
            default:
                break;
        }
    }
}