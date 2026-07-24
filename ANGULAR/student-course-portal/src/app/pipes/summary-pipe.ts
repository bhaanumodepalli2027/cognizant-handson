import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'summary',
  standalone: true
})
export class SummaryPipe implements PipeTransform {
  // 'transform' is the function Angular calls whenever you use | summary
  transform(value: string, limit: number = 20): string {
    if (!value) return '';

    // If text is longer than 'limit', cut it and attach '...'
    return value.length > limit ? value.substring(0, limit) + '...' : value;
  }
}
